package lotto.service;

import lotto.domain.Cost;
import lotto.exception.DataTypeRangeException;
import lotto.validation.CostValidator;
import lotto.view.Input;
import lotto.view.Output;

public class CostService {

    private final Input input;

    public CostService() {
        this.input = new Input();
    }

    public Cost fetchValidatedCost() {
        while (true) {
            try {
                Output.askCostEnter();
                String readLine = input.getReadLine();
                CostValidator.validateCostReadLine(readLine);
                return new Cost(validateParseNumber(readLine));
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
            }
        }
    }

    private int validateParseNumber(String readLine) {
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw DataTypeRangeException.dataTypeRangeException;
        }
    }
}
