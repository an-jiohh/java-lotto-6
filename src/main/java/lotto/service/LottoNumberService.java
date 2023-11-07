package lotto.service;

import static lotto.constants.constants.LOTTO_NUMBER_RANGE_END;
import static lotto.constants.constants.LOTTO_NUMBER_RANGE_START;
import static lotto.constants.constants.LOTTO_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoNumberService {

    public Lottos createRandomLottos(Cost cost) {
        List<Lotto> lottos = new ArrayList<>();
        while (cost.buyingLotto()) {
            Lotto randomLotto = createRandomLotto();
            lottos.add(randomLotto);
        }
        return new Lottos(lottos);
    }


    private Lotto createRandomLotto() {
        List<Integer> randomNumbers = createRandomNumbers();
        Lotto lotto = new Lotto(randomNumbers);
        return lotto;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END,
                LOTTO_NUMBER_SIZE);
        return new ArrayList<>(randomNumbers);
    }
}
