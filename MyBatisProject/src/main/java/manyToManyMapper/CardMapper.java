package manyToManyMapper;

import po.Card;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/24.
 */
interface CardMapper {
    public Card selectCardById(int id);

    public List<Card> selectCardsMoreThanScore(int score);

    public List<Card> selectCardsLessThanScore(int score);

    public List<Card> selectCardsEqualToScore(int score);

    public List<Card> selectCardByUserId(int id);

    public List<Card> selectCardsWithUserIdAndScore(Map map);
}
