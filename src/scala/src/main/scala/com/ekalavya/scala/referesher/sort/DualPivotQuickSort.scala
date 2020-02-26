package com.tantra.sort

object DualPivotQuickSort {

  def dualSort(arr:Array[Int], low:Int, high:Int):AnyVal = {
    if(low<high){
      if(arr(low)>arr(high)){
        var temp = arr(low)
        arr(low) = arr(high)
        arr(high) = temp
      }
      var p = low
      var q = high
      var k = p + 1
      var h = k
      var l = q - 1

      while(k<=l){
        if(arr(k)<arr(p)){
          var x = arr(k)
          arr(k) = arr(h)
          arr(h) = x
          h += 1
          k += 1
        }

        else if(arr(k)>arr(q)){
          var x = arr(k)
          arr(k) = arr(l)
          arr(l) = x
          l -= 1
        }

        else{
          k += 1
        }
      }
      h -= 1
      l += 1
      var x = arr(p)
      arr(p) = arr(h)
      arr(h) = x

      var y = arr(q)
      arr(q) = arr(l)
      arr(l) = y

      dualSort(arr, low, h-1)
      dualSort(arr, h+1, l-1)
      dualSort(arr, l+1, high)
    }

  }

  def main(args: Array[String]){
    var myList = Array(4,2,5,3,6,10,9,8,7)
    dualSort(myList,0,8)
    for(a <- myList){
      println(a)
    }
  }
}

