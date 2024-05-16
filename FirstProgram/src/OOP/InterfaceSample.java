package OOP;

interface Studentsz {
	public void Sget();
	public void Sdisp();
}

class Interface implements Studentsz{
	@Override
	public void Sget() {
		output("nice");
		
	}

	@Override
	public void Sdisp() {
		output("good");
	}

	public void output(String input) {
		System.out.println(input);
	}
}

public class InterfaceSample {
	public static void main(String[] args) {
		Interface obj = new Interface();
		obj.Sget();
		obj.Sdisp();
	}
}
