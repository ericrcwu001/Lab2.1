import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class StoreTester {
    @org.junit.jupiter.api.Test
    public void addBookTest() {
        Store store = new Store();
        Book book = new Book();

        store.addBook(book);
        assertTrue(true);
    }
    @org.junit.jupiter.api.Test
    public void addPhoneTest() {
        Store store = new Store();
        Phone phone = new Phone();

        store.addPhone(phone);
        assertTrue(true);
    }
    @org.junit.jupiter.api.Test
    public void locationTest() {
        Store store = new Store();
        Phone a = new Phone(), b = new Phone(), c = new Phone();
        store.addPhone(a); store.addPhone(b); store.addPhone(c);
        store.updatePhonesLocation("Room 514");
        ArrayList<CISItem> test = store.getAllPhones();
        for (CISItem e : test) {
            assertEquals(e.getLocation(), "Room 514");
        }
    }
    @org.junit.jupiter.api.Test
    public void  getItemsTest() {
        Store store = new Store();
        Phone a = new Phone(), b = new Phone();
        Book c = new Book();

        store.addPhone(a); store.addPhone(b); store.addBook(c);

        store.updatePhonesLocation("Room 514");
        ArrayList<CISItem> books = store.getItems("book");

        for(CISItem e: books){
            assertTrue(e.getClass().getSimpleName().equals("Book"));
        }
    }
    @org.junit.jupiter.api.Test
    public void  updateItems() {
        Store store = new Store();
        Phone a = new Phone(), b = new Phone();
        Book c = new Book();

        store.addPhone(a); store.addPhone(b); store.addBook(c);

        store.updateItems("phone","location","Room 514");

        for(CISItem e: store.getItems("phone")){
            if(e.getClass().getSimpleName().equals("Phone")){
                assertTrue(e.getLocation().equals("Room 514"));
            }
        }
    }
}
