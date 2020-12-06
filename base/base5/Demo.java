class Demo{
	public static void main(String[] args){
		//String s=new String("有异常！".getBytes(ISO-8859-1),"UTF-8");
		OperateInt o=new OperateInt();
		try{
			System.out.println("result is : "+o.div(4,0));
		}catch(Exception e){
			System.out.println("Exception:"+e.getMessage());
		}
	}
}