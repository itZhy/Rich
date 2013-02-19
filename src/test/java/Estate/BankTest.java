package Estate;

import Player.Feature;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BankTest {
    @Test
    public void it_should_add_account_money_earn_money(){
        //given
        Bank bank = new Bank();
        String role = Feature.MADAME_CHYAN;
        //when
        bank.earnMoney(role, 200);
        //then
        bank.withdrawMoney (role, 200);
        Bank exceptedBank = new Bank();
        exceptedBank.checkPurchasingPower(role, 200);
        assertThat(bank, is(exceptedBank));
    }

    @Test
    public void it_should_get_account_information(){
        //given
        Bank bank = new Bank();
        String role = Feature.MADAME_CHYAN;
        //when
        bank.earnMoney(role, 200);
        //then
        assertThat(bank.inquiryAccount(role), is(10200));
        assertThat(bank.inquiryAccount(Feature.UNCLE_TUU), is(10000));
    }

    @Test
    public void it_should_enjoy_privileges_after_become_vip(){
        //given
        Bank bank = new Bank();
        String role = Feature.MADAME_CHYAN;
        //when
        bank.setVip(Feature.MADAME_CHYAN);
        bank.withdrawMoney(Feature.MADAME_CHYAN, 200);
        bank.withdrawMoney(Feature.UNCLE_TUU, 200);
        //then
        assertThat(bank.inquiryAccount(Feature.MADAME_CHYAN), is(10000));
        assertThat(bank.inquiryAccount(Feature.UNCLE_TUU), is(9800));
    }

}
