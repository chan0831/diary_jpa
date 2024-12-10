package Diary.Propose.web.letter;

import Diary.Propose.domain.letter.Letter;
import Diary.Propose.domain.letter.LetterRepository;
import Diary.Propose.domain.letter.LetterType;
import Diary.Propose.domain.letter.Score;
import Diary.Propose.web.letter.form.LetterSaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/letters")
@RequiredArgsConstructor
public class LetterController {

    private final LetterRepository letterRepository;

    @ModelAttribute("letterType")
    public LetterType[] letterTypes() {return LetterType.values();}

    @ModelAttribute("score")
    public List<Score> score(){
        List<Score> score = new ArrayList<>();

        score.add(new Score("5.0", "5.0"));
        score.add(new Score("4.5", "4.5"));
        score.add(new Score("4.0", "4.0"));
        score.add(new Score("3.5", "3.5"));
        score.add(new Score("3.0", "3.0"));
        score.add(new Score("2.5", "2.5"));
        score.add(new Score("2.0", "2.0"));
        score.add(new Score("1.5", "1.5"));
        score.add(new Score("1.0", "1.0"));
        score.add(new Score("0.5", "0.5"));
        score.add(new Score("0.0", "0.0"));

        return score;
    }
    @GetMapping
    public String letters(Model model){
        List<Letter> letters = letterRepository.findAll();
        model.addAttribute("letters", letters);
        return "letters/letters";
    }

    @GetMapping("/{letterId}")
    public String letter(@PathVariable long letterId, Model model){
        Letter letter = letterRepository.findById(letterId);
        model.addAttribute("letter", letter);
        return "letters/letter";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("letter" , new Letter());
        return "letters/addForm";
    }

    @PostMapping("/add")
    public String addLetter(@Validated @ModelAttribute ("letter")LetterSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            log.info("errors{}=", bindingResult);
            return "letters/addForm";
        }

        //성공 로직
        Letter letter = new Letter();
        letter.setTitle(form.getTitle());
        letter.setDate(form.getDate());
        letter.setDay(form.getDay());
        letter.setContents(form.getContents());

        letter.setLetterType(form.getLetterType());
        letter.setScore(form.getScore());


        Letter savedLetter = letterRepository.save(letter);

        redirectAttributes.addAttribute("letterId", savedLetter.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/letters/{letterId}";
    }

    @GetMapping("/{letterId}/edit")
    public String editForm(@PathVariable Long letterId, Model model){
        Letter letter = letterRepository.findById(letterId);
        model.addAttribute("letter", letter);
        return "letters/editForm";
    }

    @PostMapping("/{letterId}/edit")
    public String edit(@PathVariable Long letterId, @ModelAttribute Letter letter){
        letterRepository.update(letterId, letter);
        return "redirect:/letters/{letterId}";
    }
}
