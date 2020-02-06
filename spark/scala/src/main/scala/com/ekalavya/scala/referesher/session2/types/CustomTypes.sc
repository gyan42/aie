
class Dollars(val amount: Int) extends AnyVal {
  override def toString() = "$" + amount
}

val money = new Dollars(1000000)
money.amount


//For example, suppose you are writing some code to generate HTML



class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal {
  override def toString: String = value
}

def title(text: Text, anchor: Anchor, style: Style): Html =
  new Html(
    s"<a id='${anchor.value}'>" +
      s"<h1 class='${style.value}'>" +
      text.value +
      "</h1></a>"
  )

title(new Text("chap:vcls"), new Anchor("bold"), new Style("Value Classes"))