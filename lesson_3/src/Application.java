import javax.swing.*;

public class Application {

    public Application() {
        System.out.println("Application->constructor");
        Model model = new Model();
        View view = new View();
        new Presenter(view, model);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Application->main");
                new Application();
            }
        });
    }

}