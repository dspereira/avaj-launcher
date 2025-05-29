package pt.dspereira.avajlauncher;

public class Simulator {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Error: Invalid number of arguments. Please provide the scenario file name.");
            return ;
        }
        Simulation simulation = new Simulation();
        simulation.setup(args[0]);
        simulation.start();
        Logger.close();
    }
}