package test.toypj.domain.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {
    private static final Map<Long, Board> store = new HashMap<>();
    private static long sequence = 0L;

    //게시글 저장
    public Board save(Board board){
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    //id로 게시글 찾기
    public Board findById(Long id){
        return store.get(id);
    }

    //전체 게시글 찾기
    public List<Board> findAll(){
        return new ArrayList<>(store.values());
    }

    //게시글 수정
    public void update(Long id, Board updateParam){
        Board findBoard = findById(id);
        findBoard.setTitle(updateParam.getTitle());
        findBoard.setContent(updateParam.getContent());
//        findBoard.setImageFiles(updateParam.getImageFiles());
    }

    //저장소 초기화
    public void clearStore(){
        store.clear();
    }
}

