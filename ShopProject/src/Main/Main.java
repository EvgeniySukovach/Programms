package Main;


import Services.CmdLineService;
import Services.impl.ClientServiceDb;
import Services.impl.ClientServiceImpl;
import Services.impl.ProductServiceDb;
import Services.impl.ProductServiceImpl;
import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException {

        CmdLineService cmdLineService = new CmdLineService(new ClientServiceDb(), new ProductServiceDb()) ;
        cmdLineService.mainMenu();



    }
}
