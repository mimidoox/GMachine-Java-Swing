package presentation;

import entities.Machine;
import services.MachineService;
import services.SalleService;

public class TestBySalle {
	
	public static void main(String[] args) {
		MachineService ms = new MachineService();
		SalleService ss = new SalleService();
		for(Machine m : ms.findMachinesBySalle(ss.findById(3)))
			System.out.println(m);
	}

}
