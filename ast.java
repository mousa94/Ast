import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ast {
	
	public String info;
	public String text;
	public String textq;
	public ast[] ref;
	
	
	public void print(ast function){
		System.out.println("Kind:-"+function.text+"  Voulme:-  "+function.info);
		if(function.ref!=null){
			for(int i=0;i<function.ref.length;i++){
				print(function.ref[i]);
			}
		}
	}
	
	public ast add(ast function){
		ast[] x;
		if(this.ref!=null){
		x=new ast[this.ref.length+1];
		}else{
		x=new ast[1];
		}
		int i=0;
		if(this.ref!=null){
		for (i = 0; i < this.ref.length; i++) {
			x[i]=this.ref[i];
		}
		}
		x[i]=new ast();
		x[i].info=function.info;
		x[i].text=function.text;
		x[i].textq=function.textq;
		if(function.ref!=null)
		{
			x[i].ref=new ast[function.ref.length];
			for (int j = 0; j < function.ref.length; j++) {
				x[i].ref[j]=function.ref[j];
			}
		}
		this.ref=x;
		return this;
		
	}
	
	public void rebulid(String func){
		
		for (int i = 0; i < func.length(); i++) {
			
		}
		
	}
	
	public ast build(String function){
		ast funcx=new ast();
		ast functionx=new ast();
		String str="";
		String txtq="";
		str=function.replaceAll("(for|while)([^;])*(;)([^;])*(;)([^\\)])*\\)", "for()");
		str=str.replace(";", ";#");
		str=str.replace("{", "#{#");
		str=str.replace("}", "#}#");
		String[] stt=str.split("#");
		int count=0;
		int cq=0;
		int cin=0;
		String stq="";
		funcx.textq="";
		for (int i = 0; i < stt.length; i++) {
			if(stt[i].contains(";")){
				count++;
				stq+=stt[i]+" ";
			}
			if(stt[i].contains("for")){
				if(count!=0){
					funcx.info=count+"";
					funcx.text="Variable Deceleration";
					funcx.ref=null;
					functionx=functionx.add(funcx);
					count=0;
					stq="";
				}
				if(!stt[i+1].contains("{")){
					funcx.info="1"+"";
					funcx.text="for";
					funcx.ref=null;
					functionx=functionx.add(funcx);
				}else{
					for(int j=i+1;j<stt.length;j++){
						if(stt[j].contains("{")){
							if(cq!=0){
								funcx.textq+=stt[j];
							}
							cq++;
						}else{if(stt[j].contains("}")){
							cq--;
							if(cq==0){
								funcx.info=cin+"";
								funcx.text="for";
								funcx.ref=null;
								if(funcx.textq.contains("{"))
								funcx.ref=build(funcx.textq).ref;
								functionx=functionx.add(funcx);
								cin=0;
								cq=0;
								i=j;
								funcx.textq="";
								break;
							}else{funcx.textq+=stt[j];}
						}else{if(!(stt[j].equals("")||stt[j].equals(" "))){
							cin++;
							funcx.textq+=stt[j];
						}
						}
						}
					}
				}
				
			}
			if(stt[i].contains("if")){
				if(count!=0){
					funcx.info=count+"";
					funcx.text="Variable Deceleration";
					funcx.ref=null;
					functionx=functionx.add(funcx);
					count=0;
					stq="";
				}
				if(!stt[i+1].contains("{")){
					funcx.info="1"+"";
					funcx.text="if";
					funcx.ref=null;
					functionx=functionx.add(funcx);
				}else{
					for(int j=i+1;j<stt.length;j++){
						if(stt[j].contains("{")){
							if(cq!=0){
								funcx.textq+=stt[j];
							}
							cq++;
						}else{if(stt[j].contains("}")){
							cq--;
							if(cq==0){
								funcx.info=cin+"";
								funcx.text="if";
								funcx.ref=null;
								if(funcx.textq.contains("{"))
								funcx.ref=build(funcx.textq).ref;
								functionx=functionx.add(funcx);
								cin=0;
								cq=0;
								i=j;
								funcx.textq="";
								break;
							}else{funcx.textq+=stt[j];}
						}else{if(!(stt[j].equals("")||stt[j].equals(" "))){
							cin++;
							funcx.textq+=stt[j];
						}
						}
						}
					}
				}
				
			}
			if(stt[i].contains("while")){
				if(count!=0){
					funcx.info=count+"";
					funcx.text="Variable Deceleration";
					funcx.ref=null;
					functionx=functionx.add(funcx);
					count=0;
					stq="";
				}
				if(!stt[i+1].contains("{")){
					funcx.info="1"+"";
					funcx.text="while";
					funcx.ref=null;
					functionx=functionx.add(funcx);
				}else{
					for(int j=i+1;j<stt.length;j++){
						if(stt[j].contains("{")){
							if(cq!=0){
								funcx.textq+=stt[j];
							}
							cq++;
						}else{if(stt[j].contains("}")){
							cq--;
							if(cq==0){
								funcx.info=cin+"";
								funcx.text="while";
								funcx.ref=null;
								if(funcx.textq.contains("{"))
								funcx.ref=build(funcx.textq).ref;
								functionx=functionx.add(funcx);
								cin=0;
								cq=0;
								i=j;
								funcx.textq="";
								break;
							}else{funcx.textq+=stt[j];}
						}else{if(!(stt[j].equals("")||stt[j].equals(" "))){
							cin++;
							funcx.textq+=stt[j];
						}
						}
						}
					}
				}
				
			}
			if(stt[i].contains("switch")){
				if(count!=0){
					funcx.info=count+"";
					funcx.text="Variable Deceleration";
					funcx.ref=null;
					functionx=functionx.add(funcx);
					count=0;
					stq="";
				}
				if(!stt[i+1].contains("{")){
					funcx.info="1"+"";
					funcx.text="switch";
					funcx.ref=null;
					functionx=functionx.add(funcx);
				}else{
					for(int j=i+1;j<stt.length;j++){
						if(stt[j].contains("{")){
							if(cq!=0){
								funcx.textq+=stt[j];
							}
							cq++;
						}else{if(stt[j].contains("}")){
							cq--;
							if(cq==0){
								funcx.info=cin+"";
								funcx.text="switch";
								funcx.ref=null;
								if(funcx.textq.contains("{"))
								funcx.ref=build(funcx.textq).ref;
								functionx=functionx.add(funcx);
								cin=0;
								cq=0;
								i=j;
								funcx.textq="";
								break;
							}else{funcx.textq+=stt[j];}
						}else{if(!(stt[j].equals("")||stt[j].equals(" "))){
							cin++;
							funcx.textq+=stt[j];
						}
						}
						}
					}
				}
				
			}
			if(stt[i].contains("else")){
				if(count!=0){
					funcx.info=count+"";
					funcx.text="Variable Deceleration";
					funcx.ref=null;
					functionx=functionx.add(funcx);
					count=0;
					stq="";
				}
				if(!stt[i+1].contains("{")){
					funcx.info="1"+"";
					funcx.text="else";
					funcx.ref=null;
					functionx=functionx.add(funcx);
				}else{
					for(int j=i+1;j<stt.length;j++){
						if(stt[j].contains("{")){
							if(cq!=0){
								funcx.textq+=stt[j];
							}
							cq++;
						}else{if(stt[j].contains("}")){
							cq--;
							if(cq==0){
								funcx.info=cin+"";
								funcx.text="else";
								funcx.ref=null;
								if(funcx.textq.contains("{"))
								funcx.ref=build(funcx.textq).ref;
								functionx=functionx.add(funcx);
								cin=0;
								cq=0;
								i=j;
								funcx.textq="";
								break;
							}else{funcx.textq+=stt[j];}
						}else{if(!(stt[j].equals("")||stt[j].equals(" "))){
							cin++;
							funcx.textq+=stt[j];
						}
						}
						}
					}
				}
				
			}
			
		}
		if(count!=0){
			funcx.info=count+"";
			funcx.text="Variable Deceleration";
			funcx.ref=null;
			functionx=functionx.add(funcx);
			count=0;
			stq=null;
		}
		return functionx;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ast func=new ast();
		func.info="for-14";
		ast a1=new ast();
		a1.info="2";
		a1.ref=null;
		ast a3=new ast();
		a3.info="for-3";
		a3.ref=null;
		ast a4=new ast();
		a4.info="1";
		a4.ref=null;
		ast a5=new ast();
		a5.info="1";
		a5.ref=null;
		ast a6=new ast();
		a6.info="if-1";
		a6.ref=null;
		ast a7=new ast();
		a7.info="else-2";
		a7.ref=null;
		ast a2=new ast();
		a2.info="for-6";
		ast[] x={a5,a6,a7};
		a2.ref=x;
		ast[] y={a1,a2,a3,a4};
		func.ref=y;
		func.print(func);
		System.out.println("++++++++++++++++++++++++++++");
		System.out.println("////////////////////////////");
		System.out.println("++++++++++++++++++++++++++++");
		String[] aa={"ast[] x;","if(this.ref!=null)","x=new ast[this.ref.length+1];","}","else","{","x=new ast[1];","}","int i=0;"," if(this.ref!=null)","{","for (i = 0; i < this.ref.length; i++)","{","x[i]=this.ref[i];","}","}","x[i]=new ast();","x[i].info=function.info;","x[i].text=function.text;","x[i].textq=function.textq;","if(function.ref!=null)","{","x[i].ref=new ast[function.ref.length];","for (int j = 0; j < function.ref.length; j++)","{","x[i].ref[j]=function.ref[j];","}","}","this.ref=x;","return this;"};
		String strx="ast[] x; if(this.ref!=null){ x=new ast[this.ref.length+1]; } else{x=new ast[1];}int i=0; if(this.ref!=null){for (i = 0; i < this.ref.length; i++){x[i]=this.ref[i];}}x[i]=new ast();x[i].info=function.info;x[i].text=function.text;x[i].textq=function.textq;if(function.ref!=null){x[i].ref=new ast[function.ref.length];for (int j = 0; j < function.ref.length; j++){x[i].ref[j]=function.ref[j];}}this.ref=x;return this;";
		func=func.build(strx);
		func.print(func);
		String str=" x[i].ref=new ast[function.ref.length]; for (int j = 0; j < function.ref.length; j++)";
		str=str.replaceAll("(for|while)([^;])*(;)([^;])*(;)([^\\)])*\\)", "for()");
		System.out.println(str);
		
		
		
		
		
		
//		ast function=new ast();
//		int c=0;
//		int cq=0;
//		int cin=0;
//		for (int i = 0; i < str.length(); i++) {
//			ast funcx=new ast();
//			if(str.charAt(i)==';')
//				c++;
//			else{
//				if(str.charAt(i)=='{'){
//					if(c!=0){
//					funcx.info=c+"";
//					funcx.ref=null;
//					function=function.add(funcx);
//					c=0;
//					}
//					for(int j=i;j<str.length();j++){
//						if(str.charAt(i)==';')
//							cin++;
//						else{
//							if(str.charAt(i)=='}')
//							{
//								if(cq==0){
//									funcx.info=cin+"";
//									funcx.ref=null;
//									function=function.add(funcx);
//									cin=0;
//									i=j+1;
//									break;
//								}else{
//									cq--;
//								}
//							}else{
//								if(str.charAt(i)=='{')
//									cq++;
//							}
//						}
//					}
//				}
//			}
//		}
//
//		
//		function.print(function);
	}

}
