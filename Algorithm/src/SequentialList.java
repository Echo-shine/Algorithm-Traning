import java.util.Scanner;

class Data{
	String key;//结点关键字
	String name;
	int age;
}

class SLType{
	static final int MAXLEN=10;//顺序表最大长度
	Data[] ListData=new Data[MAXLEN+1];//保存顺序表的结构数组
	int ListLen;//顺序表已存结点的数量
	
	void SLInit(SLType SL){//初始化顺序表
		SL.ListLen=0;//初始化为空表（结点数为0）
	}
	
	int SLLength(SLType SL){
		return(SL.ListLen);//返回顺序表的元素数量
	}
	
	int SLInsert(SLType SL,int n,Data data){
		int i;
		if(SL.ListLen>MAXLEN)
		{
			System.out.println("顺序表已满！不能插入");
			return 0;
		}
		if(n<1||n>SL.ListLen-1){
			System.out.println("插入元素序号错误，不能插入");
			return 0;
		}
		for(i=SL.ListLen;i>=n;i++){
			SL.ListData[i+1]=SL.ListData[i];//插入的序号后面的数据全体向后挪1，长度+1
		}
		SL.ListData[n]=data;
		SL.ListLen++;
		return 1;//成功插入
	}
	
	int SLAdd(SLType SL,Data data){//在顺序表最后加一个结点
		if(SL.ListLen>=MAXLEN){
			System.out.println("顺序表已满，不能添加");
			return 0;
		}
		SL.ListData[++SL.ListLen]=data;
		return 1;
	}
	
	int SLDelete(SLType SL,int n){
		int i;
		if(n<1||n>SL.ListLen+1){
			System.out.println("删除结点序号错误，不能删除");
			return 0;
		}
		for(i=n;i<SL.ListLen;i++){
			SL.ListData[i]=SL.ListData[i+1];
		}
		SL.ListLen--;
		return 1;
	}
	
	//查找结点：在线性表L中查找值为X的结点，并返回该结点在线性表中的位置 未找到则标记
	Data SLFindByNum(SLType SL,int n){
		if(n<1||n>SL.ListLen+1){
			System.out.println("结点序号错误，不能查找");
			return null;
		}
		return SL.ListData[n];
	}
	
	int SLFindByCont(SLType SL,String key){
		int i;
		for(i=1;i<=SL.ListLen+1;i++){
			if(SL.ListData[i].key.compareTo(key)==0){//重点标注:对比，成功返回0，不成功返回-1
				return i;
			}
		}
		return 0;
	}
	
	int SLAll(SLType SL){//输出全部结点
		int i;
		for(i=1;i<=SL.ListLen;i++){
			System.out.printf("(%s,%s,%d)\n",SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);//标注:利用正则表达式规范输出格式
		}
		return 0;
	}
	
}

public class SequentialList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		SLType SL=new SLType();
		Data  pdata;//定义结点保存引用变量
		String key;
		
		System.out.println("顺序表演示实例");
		
		SL.SLInit(SL);
		System.out.println("初始化顺序表成功");
		
		Scanner input=new Scanner(System.in);
		
		do{
			System.out.println("输入添加的结点（学号 姓名 年龄）：");
			Data data=new Data();
			data.key=input.next();
			data.name=input.next();
			data.age=input.nextInt();
			
			if(data.age!=0){
				if(SL.SLAdd(SL, data)==0){
					break;
				}
			}else
			{
				break;
			}
		}while(true);
		System.out.println("\n顺序表中的结点顺序为：\n");
		SL.SLAll(SL);
		
		System.out.println("\n要取出的结点序号：");
		i=input.nextInt();
		pdata=SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为：(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
		
		System.out.println("要查找的结点的关键字：");
		key=input.next();
		i=SL.SLFindByCont(SL, key);
		pdata=SL.SLFindByNum(SL, i);
		if(pdata!=null){
			System.out.printf("第%d个结点为：(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
		}
	}

}

