package pong5;
//© A+ Computer Science  -  www.apluscompsci.com
//Name - Bryan Zhang
//Date - 2018/3/25
//Class - APCSA
//Lab  - pong4

public interface Collidable5
{
	boolean didCollideLeft(Object obj);
	boolean didCollideRight(Object obj);
	boolean didCollideTop(Object obj);
	boolean didCollideBottom(Object obj);
}
