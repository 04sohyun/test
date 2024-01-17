package test.toypj.web.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.toypj.domain.board.Board;
import test.toypj.domain.board.BoardRepository;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping
    public String boards(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/boards";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable(name = "boardId") Long boardId, Model model){
        Board board = boardRepository.findById(boardId);
        model.addAttribute("board", board);
        return "board/board";
    }

    @GetMapping("/add")
    public String addForm(){
        return "board/addBoard";
    }

    @PostMapping("/add")
    public String addBoard(Board board, RedirectAttributes redirectAttributes){
        Board savedBoard = boardRepository.save(board);
        redirectAttributes.addAttribute("boardId", savedBoard.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/board/{boardId}";
    }
}
