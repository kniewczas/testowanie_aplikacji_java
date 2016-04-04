package wejsciowka02;


public interface IBreadManager {

	boolean Add(Bread bread);
	boolean Remove(int number);
	Bread Get(int code);
	boolean Find(int code);
	int ReturnSize();
}
