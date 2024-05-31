
import java.util.List;
import java.util.Scanner;

class MenuConversieKleding extends Menu {
    public MenuConversieKleding(List<String> options) {
        this.options = options;
    }

    @Override
    protected void initializeOptions() {
    }

    @Override
    public void handleChoice(int choice, Scanner scanner, MenuController menuController) {
        menuController.handleKledingMenuChoice(choice, scanner);
    }
}

class MenuConversieKledingEngels extends Menu {
    public MenuConversieKledingEngels(List<String> options) {
        this.options = options;
    }

    @Override
    protected void initializeOptions() {

    }

    @Override
    public void handleChoice(int choice, Scanner scanner, MenuController menuController) {
        menuController.handleKledingMenuChoice(choice, scanner);
    }
}
