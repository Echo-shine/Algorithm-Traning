package Stack;

public interface StackIntf {
	public void push(Object obj);//入栈
	public Object pop();//出栈
	public int size();//元素个数
	public void clear();//清空
	public void isEmpty();//判断
	public Object top();//栈首元素
}
