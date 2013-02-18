package Estate;

import Player.MadameChyan;
import Player.UncleTuu;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BankTest {
    @Test
    public void it_should_add_account_money_earn_money(){
        //given
        Bank bank = new Bank();
        String role = MadameChyan.class.toString();
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
        String role = MadameChyan.class.toString();
        //when
        bank.earnMoney(role, 200);
        //then
        assertThat(bank.inquiryAccount(role), is(10200));
        assertThat(bank.inquiryAccount(UncleTuu.class.toString()), is(10000));
    }

}
