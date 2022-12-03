package presentation;

import java.util.Date;

import entities.Machine;
import services.MachineService;

public class TestBetweenDate {

	public static void main(String[] args) {
		MachineService ms = new MachineService();
		for(Machine m : ms.findBetweenDate(new Date("2021/01/01"), new Date("2021/12/01"))) {
			System.out.println(m);
		}
	}
}
