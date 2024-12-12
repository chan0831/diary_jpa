package Diary.Propose.web.letter;

import Diary.Propose.apiPayload.code.status.ErrorStatus;
import Diary.Propose.apiPayload.exception.GeneralException;
import Diary.Propose.domain.letter.*;
import Diary.Propose.domain.member.Member;
import Diary.Propose.domain.perfume.PerfumeCommandService;
import Diary.Propose.web.converter.LetterConverter;
import Diary.Propose.web.letter.form.LetterSaveForm;
import jakarta.servlet.http.HttpSession;
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
    private final PerfumeCommandService perfumeCommandService;
    private final LetterCommandService letterCommandService;

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
        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(()-> new GeneralException(ErrorStatus.LETTER_NOT_FOUND));
        model.addAttribute("letter", letter);
        return "letters/letter";
    }

    @GetMapping("/add")
    public String addForm(Model model){
    model.addAttribute("letter" , new LetterSaveForm());
        return "letters/addForm";
    }

    @PostMapping("/add")
    public String addLetter(@Validated @ModelAttribute ("letter")LetterSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession session){

        log.info("Form data: {}", form);

        if(bindingResult.hasErrors()){
            log.info("errors{}=", bindingResult);
            return "letters/addForm";
        }

        //성공 로직
//        Letter letter = new Letter();
//        letter.setTitle(form.getTitle());
//        letter.setDate(form.getDate());
//        letter.setDay(form.getDay());
//        letter.setContents(form.getContents());
//
//        letter.setLetterType(form.getLetterType());
//        letter.setScore(form.getScore());
        // 데이터가 바인딩되었는지 확인하기 위해 form을 로그로 출력
        Member member = (Member) session.getAttribute("loginMember");

        Letter newLetter = LetterConverter.toNewLetter(form, member);


        letterRepository.save(newLetter);

        redirectAttributes.addAttribute("letterId", newLetter.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/letters/{letterId}";
    }

    @GetMapping("/{letterId}/edit")
    public String editForm(@PathVariable Long letterId, Model model){
        Letter letter = letterRepository.findById(letterId)
                .orElseThrow(()-> new GeneralException(ErrorStatus.LETTER_NOT_FOUND));

        model.addAttribute("letter", letter);
        return "letters/editForm";
    }

    @PostMapping("/{letterId}/edit")
    public String edit(@PathVariable Long letterId, @ModelAttribute Letter letter){
        letterCommandService.updateLetter(letterId, letter);

        return "redirect:/letters/{letterId}";
    }
}
