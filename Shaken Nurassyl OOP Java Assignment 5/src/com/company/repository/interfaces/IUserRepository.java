package com.company.repository.interfaces;

import com.company.entities.Necklace;
import com.company.entities.Stone;

public interface IUserRepository {
boolean addStone(Stone stone);
boolean deleteStone(int id);
Stone getStoneById(int id);
String getNecklaceById(int id);
boolean createNecklace(Necklace necklace, int amountOfStones);
boolean deleteNecklace(int id);

}
