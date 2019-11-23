# HMF-Assignment05
Help out <fill in preferred holiday-fictive-figure here> by creating a persistence layer to manage a gift list for the children of the earth.
Implement & test A DATA MODEL (NO WEB FRONTEND YET) using spring and mybatis consisting of the following business objects:

- Child (id: int, name: String; hasOne: Address, hasMany: Gifts)
- Address (id: int, text: String)
- Gift (id: int, description: String)

Implement both the n+1 and join variant for querying relationships and don't forget about transactions.

ChildrenDAO:
```
void addChild(Child child);
void removeChild(Child child);
void updateChild(Child child);
Child getChildById(int id);
Child getAllChildren();
void addGift(Child child, Gift gift); // save unpersisted gifts automatically
void removeGift(Child child, Gift gift);
```
same with AddressDAO (no gifts)

Try to find a partner for doing the assignment via pair programming.

Submit a link to an online git-based repository (private) and add me to your repo: 
GitHub: rru-hgb
Bitbucket: rru-hgb

BE PREPARED to exchange your implementations, thus take care to create "clean" code!
