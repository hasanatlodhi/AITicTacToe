package twenty20.example.aitictactoe

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var player="you"
    var moves= arrayOf(0,0,0,0,0,0,0,0,0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val first=findViewById<ImageView>(R.id.first)
        val second=findViewById<ImageView>(R.id.second)
        val third=findViewById<ImageView>(R.id.third)
        val four=findViewById<ImageView>(R.id.fourth)
        val five=findViewById<ImageView>(R.id.fifth)
        val six=findViewById<ImageView>(R.id.sixth)
        val seven=findViewById<ImageView>(R.id.seventh)
        val eight=findViewById<ImageView>(R.id.eigth)
        val nine=findViewById<ImageView>(R.id.ninth)
        first.setImageResource(0)
        second.setImageResource(0)
        third.setImageResource(0)
        four.setImageResource(0)
        five.setImageResource(0)
        six.setImageResource(0)
        seven.setImageResource(0)
        eight.setImageResource(0)
        nine.setImageResource(0)

        first.setOnClickListener()
        {
            val resource = first.drawable
            if(resource==null)
            {
                if(player=="you") {
                    first.setImageResource(R.drawable.tick)
                    moves[0] = 1
                    checkwin(moves, player)
                    player = "comp"
                    compmove()
                }

            }
        }
        second.setOnClickListener()
        {
            val resource = second.drawable
            if(resource==null)
            {
                if(player=="you") {
                    second.setImageResource(R.drawable.tick)
                    moves[1] = 1
                    checkwin(moves, player)
                    player = "comp"
                    compmove()
                }

            }
        }
        third.setOnClickListener()
        {
            val resource = third.drawable
            if(resource==null)
            {
                if(player=="you") {
                    third.setImageResource(R.drawable.tick)
                    moves[2] = 1
                    checkwin(moves, player)
                    player = "comp"
                    compmove()
                }

            }
        }
        four.setOnClickListener()
        {
            val resource = four.drawable
            if(resource==null)
            {
                if(player=="you") {
                    four.setImageResource(R.drawable.tick)
                    moves[3] = 1
                    checkwin(moves, player)
                    player = "comp"

                    compmove()
                }
            }
        }
        five.setOnClickListener()
        {
            val resource = five.drawable
            if(resource==null)
            {
                if(player=="you")
                {
                    five.setImageResource(R.drawable.tick)
                    moves[4]=1
                    checkwin(moves,player)
                    player="comp"
                    compmove()

                }
            }
        }
        six.setOnClickListener()
        {
            val resource = six.drawable
            if(resource==null)
            {
                if(player=="you")
                {
                    six.setImageResource(R.drawable.tick)

                    moves[5]=1
                    checkwin(moves,player)
                    player="comp"
                    compmove()
                }

            }
        }
        seven.setOnClickListener()
        {
            val resource = seven.drawable
            if(resource==null)
            {
                if(player=="you")
                {
                    seven.setImageResource(R.drawable.tick)

                    moves[6]=1
                    checkwin(moves,player)
                    player="comp"
                    compmove()
                }

            }
        }
        eight.setOnClickListener()
        {
            val resource = eight.drawable
            if(resource==null)
            {
                if(player=="you") {
                    eight.setImageResource(R.drawable.tick)
                    moves[7] = 1
                    checkwin(moves, player)
                    player = "comp"
                    compmove()
                }

            }
        }

        nine.setOnClickListener()
        {
            val resource = nine.drawable
            if(resource==null)
            {
                if(player=="you")
                {
                    nine.setImageResource(R.drawable.tick)
                    moves[8]=1
                    checkwin(moves,player)
                    player="comp"
                    compmove()

                }

            }
        }
    }

    fun compmove(){
        val first=findViewById<ImageView>(R.id.first)
        val second=findViewById<ImageView>(R.id.second)
        val third=findViewById<ImageView>(R.id.third)
        val four=findViewById<ImageView>(R.id.fourth)
        val five=findViewById<ImageView>(R.id.fifth)
        val six=findViewById<ImageView>(R.id.sixth)
        val seven=findViewById<ImageView>(R.id.seventh)
        val eight=findViewById<ImageView>(R.id.eigth)
        val nine=findViewById<ImageView>(R.id.ninth)
        val bestmove=Minimax()
        val best= bestmove.findBestMove(moves)
        val pos=best.row*3+best.col
        if(pos==0)
        {

            first.setImageResource(R.drawable.xp)
            moves[0]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==1)
        {

            second.setImageResource(R.drawable.xp)
            moves[1]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==2)
        {

            third.setImageResource(R.drawable.xp)
            moves[2]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==3)
        {

            four.setImageResource(R.drawable.xp)
            moves[3]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==4)
        {

            five.setImageResource(R.drawable.xp)
            moves[4]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==5)
        {

            six.setImageResource(R.drawable.xp)
            moves[5]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==6)
        {

            seven.setImageResource(R.drawable.xp)
            moves[6]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==7)
        {

            eight.setImageResource(R.drawable.xp)
            moves[7]=2
            checkwin(moves,player)
            player="you"
        }
        if(pos==8)
        {

            nine.setImageResource(R.drawable.xp)
            moves[8]=2
            checkwin(moves,player)
            player="you"
        }


    }

    fun checkwin(moves:Array<Int>, player:String)
    {
        if((moves[0]==moves[1] && moves[0]==moves[2] && moves[0]!=0) || (moves[0]==moves[3] && moves[0]==moves[6] && moves[0]!=0) || (moves[1]==moves[4] && moves[1]==moves[7] && moves[1]!=0) ||(moves[2]==moves[5] && moves[2]==moves[8] && moves[2]!=0) || (moves[3]==moves[4] && moves[3]==moves[5] && moves[3]!=0) || (moves[6]==moves[7] && moves[6]==moves[8] && moves[6]!=0) || (moves[0]==moves[4] && moves[0]==moves[8] && moves[0]!=0) || (moves[2]==moves[4] && moves[2]==moves[6] && moves[2]!=0))
        {
            if(player=="you"){
                val toast=Toast.makeText(this,"You Win!!",Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            else
            {
                val toast=Toast.makeText(this,"Computer Wins!!",Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
            Handler().postDelayed(
                {
                    clearboard()
                },2000)

        }
        else if(moves[0]!=0 && moves[1]!=0 && moves[2]!=0 && moves[3]!=0 && moves[4]!=0 && moves[5]!=0 && moves[6]!=0 && moves[7]!=0 && moves[8]!=0)
        {
            val toast=Toast.makeText(this,"Game Draw!",Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
            Handler().postDelayed(
                {
                    clearboard()
                },2000)
        }

    }
    fun clearboard()
    {

        val first=findViewById<ImageView>(R.id.first)
        first.setImageResource(0)

        val second=findViewById<ImageView>(R.id.second)
        second.setImageResource(0)

        val third=findViewById<ImageView>(R.id.third)
        third.setImageResource(0)

        val four=findViewById<ImageView>(R.id.fourth)
        four.setImageResource(0)

        val five=findViewById<ImageView>(R.id.fifth)
        five.setImageResource(0)
        val six=findViewById<ImageView>(R.id.sixth)
        six.setImageResource(0)
        val seven=findViewById<ImageView>(R.id.seventh)
        seven.setImageResource(0)

        val eight=findViewById<ImageView>(R.id.eigth)
        eight.setImageResource(0)

        val nine=findViewById<ImageView>(R.id.ninth)
        nine.setImageResource(0)
        player="you"
        for (i in 0..8)
        {
            moves[i]=0
        }
    }

}