import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of the board: ");
        int BoardSize=sc.nextInt();
        System.out.println("enter the num of snakes: ");
        int NumofSnakes=sc.nextInt();
        int[][] Snakes=new int[NumofSnakes][2];
        for (int i=0;i<NumofSnakes;i++){
            System.out.println("enter position of head for snake" +(i+1)+":");
            Snakes[i][0]=sc.nextInt();
            System.out.println("enter the tail position"+(i+1)+":");
            Snakes[i][1]= sc.nextInt();
        }
        System.out.println("enter the num of ladders: ");
        int numofLadder= sc.nextInt();
        int[][] Ladders=new int[numofLadder][2];
        for (int i=0;i<numofLadder;i++){
            System.out.println("enter the head position of ladder"+(i+1)+":");
            Ladders[i][0]= sc.nextInt();
            System.out.println("enter the tail position of ladder"+(i+1)+":");
            Ladders[i][1]= sc.nextInt();
        }
        System.out.println("enter the num of players: ");
        int NumofPlayers=sc.nextInt();
        String[] Players=new String[NumofPlayers];
        for (int i=0;i<NumofSnakes;i++){
            System.out.println("enter the player name"+(i+1)+":");
            Players[i]= sc.next();
        }
        int [] PlayersPosition=new int[NumofPlayers];
        while(true){
            for (int i=0;i<NumofPlayers;i++){
                int diceroll=rollDice();
                PlayersPosition[i] += diceroll;

                for (int[]snakes:Snakes){
                    if (PlayersPosition[i] ==snakes[0]){
                        PlayersPosition[i]=snakes[1];
                        break;
                    }
                }
                for (int[]ladders:Ladders){
                    if (PlayersPosition[i] == ladders[0]){
                        PlayersPosition[i] = ladders[1];
                        break;
                    }
                }
                if (PlayersPosition[i] == 100){
                    System.out.println(Players[i]+" is the winner");
                    return;
                }else if(PlayersPosition[i]>100){
                    PlayersPosition[i] -= diceroll;

                }
                System.out.println(Players[i]+"Rolled"+diceroll+"moved from "+(PlayersPosition[i]-diceroll)+"to"+PlayersPosition[i]+".");
            }
        }

    }
    private static int rollDice(){
        Random rd=new Random();
        return rd.nextInt(6)+1;
    }

}