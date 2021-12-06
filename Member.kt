class Member(private val firstName: String, private val lastName: String, private val group: Int) {

    private var giver //the person who gives you a gift
            : Member? = null
    private var receiver //the person who receives a gift from you
            : Member? = null

    fun getFirstName(): String{
        return firstName
    }
    fun getReceiver(): Member? {
        return receiver
    }
    fun getGroup(): Int{
        return group
    }
    private fun sameMember(member: Member): Boolean {
        return firstName === member.firstName && lastName === member.lastName
    }

    private fun sameGroup(member: Member): Boolean {
        return group == member.group
    }

    private fun hasGiver(member: Member): Boolean {
        return member.giver != null
    }

    fun goodReciever(member: Member): Boolean {
        return !(sameGroup(member) || sameMember(member) || hasGiver(member))
    }

    fun addGiver(giver: Member) {
        this.giver = giver
    }

    fun addReciever(receiver: Member) {
        this.receiver = receiver
    }
}