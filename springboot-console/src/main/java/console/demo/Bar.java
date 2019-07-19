package console.demo;

public class Bar {
	Foo f;
	public Bar(Foo foo) {
		f = foo;
	}
	
	public String getValue123()
	{
		return f.value;
	}
}
