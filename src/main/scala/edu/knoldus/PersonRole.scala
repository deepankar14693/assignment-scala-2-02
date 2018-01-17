package edu.knoldus

import java.util

import org.apache.log4j.Logger.getLogger

abstract class PersonRole {
class Gamer extends PersonRole
 class Trainer extends PersonRole
 class Blogger extends PersonRole
}

object Role extends PersonRole with App {

 def specifyRole(person: PersonRole) : String ={
person match {
 case first : Gamer => gamerResponse(gamingcount)
 case second : Trainer => trainerResponse
 case third : Blogger => bloggerResponse(blogwritten,blogcount)
  }
}

 val start = 1
 val end   = 6
 val rnd = new scala.util.Random
 val random=rnd.nextInt( (end - start) + 1 )

 def gamerResponse(count: Int) : String = {
  count match {
   case 0 => "you are winner"
   case _ => { if (random equals(1) )
   {
    gamerResponse(count - 1)
   }
   else if (random equals(6))
   {
    gamerResponse(count-1)
   }
   else
   {
    "you are looser"
   }
   }
  }
 }

 val first = 1
 val last = 50
 val attendance = new scala.util.Random
 val strength=attendance.nextInt((last - first) + 1 )


 def trainerResponse(): String={
s"today's attendance is $strength out of 50 "
 }

 val beg = 0
 val length = 2
 val total = new scala.util.Random
 val add=total.nextInt((length - beg) + 1 )

 def bloggerResponse(blog: Map[String,Int],count: Int) : String= {
def addBlogs(blog: Map[String,Int],randomval: Int,count: Int): String=
  {
   count match {
    case 0 => {val c = blog.maxBy(_._2)
      s"max blogs value are in $c"}
    case _ => {  if (randomval equals(0))
           {
      val add=total.nextInt((length - beg) + 1 )
      (blog("scala") + 1)
      addBlogs(blog,add,count-1)
              }
    else if (randomval equals(1))
    {
     val add=total.nextInt((length - beg) + 1 )
     (blog("java") + 1)
     addBlogs(blog,add,count-1)
    }
     else
     {
      val add=total.nextInt((length - beg) + 1 )
      (blog("kafka") + 1)
      addBlogs(blog,add,count-1)
    }
    }
   }
  }
addBlogs(blog,add,count)
 }
 val gamingcount=3
 val blogcount=5
 val log = getLogger(this.getClass)
 val blogwritten=Map("scala" -> 2,"java" -> 5,"kafka" -> 6)
 val game=new Gamer
 log.debug(specifyRole(game) + " \n")
 val train=new Trainer
 log.debug(specifyRole(train) + " \n")
 val blog=new Blogger
 log.debug(specifyRole(blog) + " \n")
}


