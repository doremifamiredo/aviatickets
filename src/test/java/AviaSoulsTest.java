import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    Ticket t1 = new Ticket("MSK", "SPB", 3_000, 1000, 1130); //130
    Ticket t2 = new Ticket("SPB", "RND", 10_800, 1100, 1500); //400
    Ticket t3 = new Ticket("MSK", "KRD", 12_000, 1220, 1440); //220
    Ticket t4 = new Ticket("MSK", "SPB", 2_850, 1210, 1330); //120
    Ticket t5 = new Ticket("MSK", "SPB", 3_050, 1315, 1430); //115
    Ticket t6 = new Ticket("MLN", "ROM", 1_500, 1100, 1200); //200
    Ticket t7 = new Ticket("MSK", "SPB", 3_300, 1500, 1635); //135
    Ticket t8 = new Ticket("MSK", "SPB", 2_700, 1400, 1540); //140

    @Test
    public void compareToTest() {
        AviaSouls manager = new AviaSouls();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);

        Arrays.sort(manager.findAll());
        Ticket[] expected = {t4, t1, t5, t2, t3};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void findAndSortFiveTickets() {
        AviaSouls manager = new AviaSouls();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t8, t4, t1, t5, t7};
        Assertions.assertArrayEquals(expected, manager.search("MSK", "SPB"));
    }

    @Test
    public void findOneTicket() {
        AviaSouls manager = new AviaSouls();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t6};
        Assertions.assertArrayEquals(expected, manager.search("MLN", "ROM"));
    }

    @Test
    public void findNoOneTicket() {
        AviaSouls manager = new AviaSouls();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.search("MLN", "SPB"));
    }

    @Test
    public void sortFiveTicketsByTime() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t5, t4, t1, t7, t8};
        Assertions.assertArrayEquals(expected, manager.search("MSK", "SPB", comparator));
    }

    @Test
    public void sortOneTicketByTime() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t6};
        Assertions.assertArrayEquals(expected, manager.search("MLN", "ROM", comparator));
    }

    @Test
    public void sortNoOneTicketByTime() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, manager.search("MLN", "SPB", comparator));
    }
}