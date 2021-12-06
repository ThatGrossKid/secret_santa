import java.util.*

class SantaSelection(private val familyMembers: List<Member>) {
    fun giftSelector() {
        val indiciesLeft: MutableList<Int> = ArrayList()
        var remaining = familyMembers.size
        for (i in familyMembers.indices) {
            indiciesLeft.add(i)
        }
        val random = Random()
        for (i in familyMembers.indices) {
            var goodSelection = false
            while (!goodSelection) {
                val selectIndex = indiciesLeft[random.nextInt(remaining)]
                if (familyMembers[i].goodReciever(familyMembers[selectIndex])) {
                    familyMembers[i].addReciever(familyMembers[selectIndex])
                    familyMembers[selectIndex].addGiver(familyMembers[i])
                    println(
                        familyMembers[i].getFirstName() + " gives a gift to " +
                                familyMembers[selectIndex].getFirstName()
                    )
                    indiciesLeft.removeAt(indiciesLeft.indexOf(selectIndex))
                    goodSelection = true
                    remaining--
                }
                else if((familyMembers[i]==familyMembers[selectIndex]||
                    familyMembers[i].getGroup()==familyMembers[selectIndex].getGroup())&&remaining==1){
                    var j = 0
                    while(!goodSelection){
                        if(familyMembers[j].getReceiver()?.let { familyMembers[i].goodReciever(it) } == true){
                            familyMembers[j].getReceiver()?.let { familyMembers[i].addReciever(it) }
                            familyMembers[j].addReciever(familyMembers[i])
                            println("Change in system\n"+familyMembers[j].getFirstName()+ " now gives a gift to "
                            + (familyMembers[j].getReceiver()?.getFirstName() ?:String)
                            )
                            println(
                                familyMembers[i].getFirstName() + " gives a gift to " +
                                        familyMembers[selectIndex].getFirstName()
                            )
                            indiciesLeft.removeAt(indiciesLeft.indexOf(selectIndex))
                            goodSelection = true
                            remaining--
                        }
                        else{
                            j++
                        }
                    }
                }
            }
        }
    }
}