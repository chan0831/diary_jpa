package Diary.Propose.web.perfume;

import Diary.Propose.domain.letter.Score;
import Diary.Propose.domain.perfume.Perfume;
import Diary.Propose.domain.perfume.PerfumeRepository;
import Diary.Propose.domain.perfume.Rating;
import Diary.Propose.web.perfume.form.PerfumeSaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//향수 메인 -> /perfumes
//향수 목록 -> /perfumes/perfumes
//향수 상세 -> /perfumes/perfumes/perfume
//향수 수정 -> /perfumes/update
//향수 등록 -> /perfumes/add
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/perfumes")
public class PerfumeController {

    private final PerfumeRepository perfumeRepository;

    @ModelAttribute("rating")
    public List<Rating> rating(){
        List<Rating> rating = new ArrayList<>();

        rating.add(new Rating("5.0", "5.0"));
        rating.add(new Rating("4.5", "4.5"));
        rating.add(new Rating("4.0", "4.0"));
        rating.add(new Rating("3.5", "3.5"));
        rating.add(new Rating("3.0", "3.0"));
        rating.add(new Rating("2.5", "2.5"));
        rating.add(new Rating("2.0", "2.0"));
        rating.add(new Rating("1.5", "1.5"));
        rating.add(new Rating("1.0", "1.0"));
        rating.add(new Rating("0.5", "0.5"));
        rating.add(new Rating("0.0", "0.0"));

        return rating;
    }

    @ModelAttribute("accords")
    public Map<String,String> accords(){
        Map<String, String> accords = new LinkedHashMap<>();
        accords.put("spicy", "spicy");
        accords.put("woody", "woody");
        accords.put("citrus","citrus");
        accords.put("sweet","sweet");
        accords.put("musky","musky");
        accords.put("gourmand","gourmand");
        accords.put("floral","floral");
        accords.put("fruity","fruity");
        accords.put("green","green");
        accords.put("amber","amber");
        accords.put("lactonic","lactonic");
        accords.put("aldehydic","aldehydic");
        accords.put("earthy","earthy");
        accords.put("fresh","fresh");
        accords.put("powdery","powdery");
        accords.put("aquatic","aquatic");
        accords.put("aromatic","aromatic");
        accords.put("salty","salty");
        accords.put("metalic","metalic");
        accords.put("oriental","oriental");
        accords.put("vanilla","vanilla");
        accords.put("watery","watery");
        accords.put("nutty","nutty");



        return accords;
    }

    @ModelAttribute("season")
    public Map<String, String> season(){
        Map<String, String> season = new LinkedHashMap<>();
        season.put("spring", "봄");
        season.put("summer", "여름");
        season.put("fall", "가을");
        season.put("winter", "겨울");
        return season;
    }

    @GetMapping("/perfumes/{perfumeId}")
    public String perfume(@PathVariable long perfumeId, Model model){
        Perfume perfume = perfumeRepository.findById(perfumeId);
        model.addAttribute("perfume", perfume);
        return "perfumes/perfume";
    }

    @GetMapping("/perfumes")
    public String perfumes(Model model){
        List<Perfume> perfumes = perfumeRepository.findAll();
        model.addAttribute("perfumes", perfumes);
        return "perfumes/perfumes";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("perfume", new Perfume());
        return "perfumes/addForm";
    }

    @PostMapping("/add")
    public String addPerfume(@Validated @ModelAttribute ("perfume")PerfumeSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            log.info("errors{}=", bindingResult);
            return "perfumes/addForm";
        }

        Perfume perfume = new Perfume();
        perfume.setPerfumeName(form.getPerfumeName());
        perfume.setBrand(form.getBrand());
        perfume.setDate(form.getDate());
        perfume.setAccords(form.getAccords());
        perfume.setTopNote(form.getTopNote());
        perfume.setMiddleNote(form.getMiddleNote());
        perfume.setBaseNote(form.getBaseNote());
        perfume.setSeason(form.getSeason());
        perfume.setRating(form.getRating());
        perfume.setReview(form.getReview());

        Perfume savedPerfume = perfumeRepository.save(perfume);

        redirectAttributes.addAttribute("perfumeId", savedPerfume.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/perfumes/perfumes/{perfumeId}";
    }

    @GetMapping("/perfumes/{perfumeId}/edit")
    public String editForm(@PathVariable Long perfumeId, Model model){
        Perfume perfume = perfumeRepository.findById(perfumeId);
        model.addAttribute("perfume", perfume);
        return "perfumes/editForm";
    }

    @PostMapping("/perfumes/{perfumeId}/edit")
    public String edit(@PathVariable Long perfumeId, @ModelAttribute Perfume perfume){
        perfumeRepository.update(perfumeId, perfume);
        return "redirect:/perfumes/perfumes/{perfumeId}";
    }
}
