package com.giotto.rgjc.bean;

import java.sql.Timestamp;

public class Order {
	private int no;
	private String status;
	private String reason;
	private String newMan;
	private String judMan;
	private String proType;
	private String material;
	private int amount;
	private String attention;
	private String qualify;
	private String date;
	private String ifTry;
	private String process;
	private String jindu;
	
	public int getNo()
	{
		return this.no;
	}

	public String getStatus()
	{
		return this.status;
	}
	
	public String getReason()
	{
		return this.reason;
	}
	
	public String getNewMan()
	{
		return this.newMan;
	}
	
	public String getJudMan()
	{
		return this.judMan;
	}
	
	public String getProType()
	{
		return this.proType;
	}
	
	public String getMaterial()
	{
		return this.material;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	
	public String getAttention()
	{
		return this.attention;
	}
	
	public String getQualify()
	{
		return this.qualify;
	}
	
	
	public String getDate()
	{
		return this.date;
	}
	
	public String getIfTry()
	{
		return this.ifTry;
	}
	
	public String getProcess()
	{
		return this.process;
	}
	
	public String getJindu()
	{
		return this.jindu;
	}
	
	public void setNo(int str)
	{
		this.no=str;
	}

	public void setStatus(String str)
	{
		this.status=str;
	}
	

	public void setReason(String str)
	{
		this.reason=str;
	}

	public void setNewMan(String str)
	{
		this.newMan=str;
	}

	public void setJudMan(String str)
	{
		this.judMan=str;
	}

	public void setProType(String str)
	{
		this.proType=str;
	}

	public void setMaterial(String str)
	{
		this.material=str;
	}
	

	public void setAmount(int i)
	{
		this.amount=i;
	}
	

	public void setAttention(String str)
	{
		this.attention=str;
	}
	
	public void setQualify(String str)
	{
		this.qualify=str;
	}


	public void setDate(String str)
	{
		this.date=str;
	}

	public void setIfTry(String str)
	{
		this.ifTry=str;
	}

	public void setProcess(String str)
	{
		this.process=str;
	}

	public void setJindu(String str)
	{
		this.jindu=str;
	}
}
