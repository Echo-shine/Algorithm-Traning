package List;

import java.util.Scanner;

class Data{
	String key;
	String name;
	int age;
}

class CLType{//定义链表结构
	Data nodeData=new Data();
	CLType nextNode;
	
	CLType CLAddEnd(CLType head,Data nodeData){//在表尾追加结点
		CLType node,htemp;
		if((node=new CLType())==null){
			System.out.println("内存分配失败！");
			return null;
		}else{
			node.nodeData=nodeData;
			node.nextNode=null;
			if(head==null){
				head=node;
				return head;
			}
			htemp=head;
			while(htemp.nextNode!=null){
				htemp=htemp.nextNode;
			}
			htemp.nextNode=node;
			return head;
		}	
	}
	CLType CLAddFirst(CLType head,Data nodeData){//在表头添加结点
		CLType node;
		if((node=new CLType())==null){
			System.out.println("内存分配失败！");
			return null;
		}else{
			node.nextNode=head;
			node.nodeData=nodeData;
			head=node;
			return head;
		}
	}
	CLType CLFindNode(CLType head,String key){//关键字查找结点
		CLType htemp;
		htemp=head;
		while(htemp!=null){
			if(htemp.nodeData.key.compareTo(key)==0){
				return htemp;
			}
			htemp=htemp.nextNode;
		}
	return null;
	}
	CLType CLInsertNode(CLType head,String findkey,Data nodeData){//插入结点
		CLType node,nodetemp;
		if((node=new CLType())==null){
			System.out.println("内存分配失败！");
			return null;
		}
		node.nodeData=nodeData;
		nodetemp=CLFindNode(head,findkey);
		if(nodetemp!=null){
			node.nextNode=nodetemp.nextNode;
			nodetemp.nextNode=node;
		}else{
			System.out.println("未找到正确的存储位置！");
		}
			return head;
	}
	int CLDeleteNode(CLType head,String key){//删除结点
		CLType node,htemp;
		htemp=head;
		node=head;
		while(htemp!=null){
			if(htemp.nodeData.key.compareTo(key)==0){
				node.nextNode=htemp.nextNode;
				htemp=null;
				return 1;
			}else{
				node=htemp;
				htemp=htemp.nextNode;
			}
		}
		return 0;
	}
	int CLLength(CLType head){//计算链表长度
		CLType htemp;
		int len=0;
		htemp=head;
		if(htemp.nextNode!=null){
			len++;
			htemp=htemp.nextNode;
		}
		return len;
	}
	void CLAllNode(CLType head){//遍历链表
		CLType htemp;
		Data nodeData;
		htemp=head;
		System.out.printf("当前链表有%d个结点，所有数据如下：\n",CLLength(head));
		while(htemp!=null){
			nodeData=htemp.nodeData;
			System.out.printf("结点(%s,%s,%d):"+nodeData.key,nodeData.name,nodeData.age);
			htemp=htemp.nextNode;
		}
		
	}
		

public  class LinkedList {

	public  void main(String[] args) {
		// TODO Auto-generated method stub
		CLType node,head=null;
		CLType cl=new CLType();
		String key,findkey;
		Scanner input=new Scanner(System.in);
		
		System.out.println("LinkedList Test: Input the data with 'key name age'");
		do{
			Data nodeData=new Data();
			nodeData.key=input.next();
			if(nodeData.key.equals("0")){
				break;
			}
			else{
				nodeData.name=input.next();
				nodeData.age=input.nextInt();
				head=cl.CLAddEnd(head, nodeData);
			}	
		}while(true);
		cl.CLAllNode(head);
		
		System.out.println("Over……");
	}
}
}


