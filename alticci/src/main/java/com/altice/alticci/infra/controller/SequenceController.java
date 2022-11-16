package com.altice.alticci.infra.controller;

import com.altice.alticci.domain.exception.BadRequestException;
import com.altice.alticci.domain.service.AlticciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Tag(name = "Alticci sequence", description = "Alticci sequence API")
@RestController
@RequestMapping("/alticci")
@AllArgsConstructor
public class SequenceController {

    private AlticciService alticciService;

    @Operation(summary = "Get alticci value by number",
            description = "Returns the calculated value for the given number")
    @ApiResponses({
            @ApiResponse(description = "OK", responseCode = "200"),
            @ApiResponse(description = "BAD_REQUEST", responseCode = "400"),
            @ApiResponse(description = "INTERNAL_SERVER_ERROR", responseCode = "500")
    })
    @GetMapping("/{number}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal generate(@PathVariable Long number) throws BadRequestException {
        return alticciService.calculate(number).getValue();
    }
}
