package ru.aaaTurbo.coffeeMachineApp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.StartCommand;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.StopCommand;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.listener.MyCommandListener;
import ru.aaaTurbo.coffeeMachineApp.classes.commands.parser.Parser;
import ru.aaaTurbo.coffeeMachineApp.database.entities.CommandEntity;
import ru.aaaTurbo.coffeeMachineApp.database.service.CommandServiceImpl;
import ru.aaaTurbo.coffeeMachineApp.util.abstracts.Command;
import ru.aaaTurbo.coffeeMachineApp.util.exceptions.WrongInputException;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Command controller", description = "Handles requests and translates commands to coffee machine")
public class CommandController {

    private final CommandServiceImpl service;
    private final MyCommandListener listener;
    private final Parser parser;

    @Autowired
    public CommandController(CommandServiceImpl service, MyCommandListener listener, Parser parser) {
        this.service = service;
        this.listener = listener;
        this.parser = parser;
    }

    @PostMapping("/control")
    @Operation(description = "Sends command and saves it. " +
            "Insert type of operation. It can be: MAKE_...(f.e. MAKE_LATTE), TURN_ON, TURN_OFF, CLEAN, HEAT. " +
            "Command must have only one '_'!",
            summary = "Sends command",
            responses = {@ApiResponse(description = "Command logged!", responseCode = "201",
                            content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(description = "Command not found!", responseCode = "404",
                            content = @Content(schema = @Schema(hidden = true))),
                    @ApiResponse(description = "Wrong input!", responseCode = "400",
                            content = @Content(schema = @Schema(hidden = true)))},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Command", content = @Content(schema = @Schema(example = "MAKE_LATTE"))))
    public ResponseEntity<String> save(@RequestBody String command) {
        try {
            Command parsedCommand = parser.parse(command);
            if (parsedCommand == null) {
                return new ResponseEntity<>("Command not found!", HttpStatus.NOT_FOUND);
            } else {
                String status = listener.execute(parsedCommand);
                service.save(new CommandEntity(command, status));
                return new ResponseEntity<>(status, HttpStatus.CREATED);
            }
        } catch (WrongInputException wi) {
            return new ResponseEntity<>(wi.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/control")
    @Operation(description = "Returns the log of commands which are saved in PSQL.\n" +
            "P.S. If we have some form, it will be better to set time from client JS.",
            summary = "Get commands log",
            responses = @ApiResponse(description = "See the log!", responseCode = "200",
                    content = @Content(schema = @Schema(hidden = true))))
    public ResponseEntity<List<String>> get() {
        List<String> log = new ArrayList<>();
        service.getAll().forEach(commandEntity -> {
            log.add(commandEntity.toString());
        });
        return new ResponseEntity<>(log, HttpStatus.OK);
    }

    @PostConstruct
    public void init() {
        String status = listener.execute(new StartCommand());
        service.save(new CommandEntity("TURN_ON", status));
    }

    @PreDestroy
    public void destroy() {
        String status = listener.execute(new StopCommand());
        service.save(new CommandEntity("TURN_OFF", status));
    }

}
