package Diary.Propose.web.converter;

import Diary.Propose.domain.member.Member;
import Diary.Propose.domain.perfume.Perfume;
import Diary.Propose.web.perfume.form.PerfumeSaveForm;

public class PerfumeConverter {

    public static Perfume toPerfume(PerfumeSaveForm form, Member member){
        return Perfume.builder()
                .perfumeName(form.getPerfumeName())
                .brand(form.getBrand())
                .topNote(form.getTopNote())
                .middleNote(form.getMiddleNote())
                .baseNote(form.getBaseNote())
                .rating(form.getRating())
                .review(form.getReview())
                .season(form.getSeason())
                .date(form.getDate())
                .member(member)
                .accords(form.getAccords())
                .build();
    }

    public static Perfume updatePerfume(Perfume perfume, Perfume updateParam){
        return Perfume.builder()
                .id(perfume.getId())
                .perfumeName(updateParam.getPerfumeName())
                .brand(updateParam.getBrand())
                .topNote(updateParam.getTopNote())
                .middleNote(updateParam.getMiddleNote())
                .baseNote(updateParam.getBaseNote())
                .rating(updateParam.getRating())
                .review(updateParam.getReview())
                .season(updateParam.getSeason())
                .date(updateParam.getDate())
                .accords(updateParam.getAccords())
                .build();
    }
}
