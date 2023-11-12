import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Store {
    private ArrayList<CISItem> cisItems = new ArrayList<>();
    public void addBook(Book book) {
        cisItems.add(book);
    }
    public void addPhone(Phone phone) {
        cisItems.add(phone);
    }
    public void updatePhonesLocation(String loc) {
        for (CISItem e : cisItems) {
            if (e.getClass() == Phone.class) {
                e.setLocation(loc);
            }
        }
    }
    public ArrayList<CISItem> getAllPhones() {
        ArrayList<CISItem> phones = new ArrayList<>();
        for (CISItem e : cisItems) {
            if (e.getClass() == Phone.class) {
                phones.add(e);
            }
        }
        return phones;
    }
    public ArrayList<CISItem> getItems(String itemType) {
        ArrayList<CISItem> items = new ArrayList<>();
        for (CISItem e : cisItems) {
            if (itemType.equalsIgnoreCase(String.valueOf(e.getClass()))) {
                items.add(e);
            }
        }
        return items;
    }
    public void updateItems(String itemType, String property, String value) {
        itemType = capitalize(itemType);
        property = capitalize(property);
        value = capitalize(value);
        for (CISItem e : cisItems) {
            if (itemType.equalsIgnoreCase(e.getClass().getSimpleName())) {
                try {
                    Method setterMethod = e.getClass().getMethod("set" + property, String.class);
                    setterMethod.invoke(e, value);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void showAllInfo(){
        for (CISItem e : cisItems) {
            System.out.println("location: " + e.getLocation() + " name: "+e.getName() + " price: " + e.getPrice() + " description: " + e.getDescription());
        }
    }
    private String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }
}
