import java.util.List;

public interface Application {
    public void login();
    public List<Item> getItemsList();
    public boolean editItem(int itemID);
    public void logout();
}
