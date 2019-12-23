package com.service.victoria.service;

import com.service.victoria.beans.GameResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GameService.class)
@AutoConfigureMockMvc
class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Test
    public void test_circular_id_creation_for_all_students() throws Exception {
        GameService.Node node = gameService.createCircularLinkedList(5);
        assertEquals(node.data, 1);
        node = node.next;
        assertEquals(node.data, 2);
        node = node.next;
        assertEquals(node.data, 3);
        node = node.next;
        assertEquals(node.data, 4);
        node = node.next;
        assertEquals(node.data, 5);
    }

    @Test
    public void test_removed_child_list_is_in_correct_order() throws Exception {
        GameResponse response = gameService.getLastChildPosition(5, 2);
        List<Integer> removedChildList = response.getRemovedChildList();
        assertEquals(removedChildList.get(0), 2);
        assertEquals(removedChildList.get(1), 4);
        assertEquals(removedChildList.get(2), 1);
        assertEquals(removedChildList.get(3), 5);
        assertEquals(response.getWinningChildId(), 3);
    }

    @Test
    public void test_removed_child_list_is_in_correct_order_and_produces_correct_output() throws Exception {
        GameResponse response = gameService.getLastChildPosition(14, 6);
        List<Integer> removedChildList = response.getRemovedChildList();
        removedChildList.forEach(System.out::println);
        assertEquals(removedChildList.get(0), 6);
        assertEquals(removedChildList.get(1), 12);
        assertEquals(removedChildList.get(2), 4);
        assertEquals(removedChildList.get(3), 11);
        assertEquals(removedChildList.get(4), 5);
        assertEquals(removedChildList.get(5), 14);
        assertEquals(removedChildList.get(6), 9);
        assertEquals(removedChildList.get(7), 7);
        assertEquals(removedChildList.get(8), 3);
        assertEquals(removedChildList.get(9), 8);
        assertEquals(removedChildList.get(10), 13);
        assertEquals(removedChildList.get(11), 10);
        assertEquals(removedChildList.get(12), 2);

        assertEquals(response.getWinningChildId(), 1);
    }
}