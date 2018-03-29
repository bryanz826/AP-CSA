package pong4;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong4

public interface Collidable4 
{
	boolean didCollideLeft(Object obj);
	boolean didCollideRight(Object obj);
	boolean didCollideTop(Object obj);
	boolean didCollideBottom(Object obj);
}
