package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.Domain.model.Unit;
import org.studentmanagementsystem.Repo.impl.GradeRepository;
import org.studentmanagementsystem.dto.CurrentProgress;
import org.studentmanagementsystem.exceptions.FailedToCreateGrade;
import org.studentmanagementsystem.service.GradeInterface;
import org.studentmanagementsystem.utils.Utilities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class GradeService implements GradeInterface {

    StudentServiceImpl studentService;
    CourseServiceImpl courseService;
    GradeRepository gradeRepo;

    public GradeService() {
        this.studentService = new StudentServiceImpl();
        this.courseService = new CourseServiceImpl();
        this.gradeRepo = new GradeRepository();
    }

    @Override
    public void enterGradeForStudent(Scanner scanner, int regNumber) {
        Student  student = studentService.retrieveStudentById(regNumber);
        CurrentProgress currentProgress = courseService.getStudentCurrentProgress(regNumber);
        if (currentProgress == null) {
            System.out.println("This student has no active semester progress.");
            return;
        }
        List<Unit> units = courseService.getUnitsBySemester(currentProgress.getSemester_id());

        System.out.println("Entering grades for: " + student.getName() + " — " + currentProgress.getSemester_name());

        for (Unit unit : units) {
            System.out.print("Score for " + unit.getUnit_name() + ": ");
            BigDecimal score = new BigDecimal(scanner.nextLine());
            String letter = Utilities.CalculateGradeLetter(score); // your own logic, e.g. A/B/C thresholds

            createGrade(currentProgress.getProgress_id(), unit.getUnit_id(), score, letter);
        }
    }

    public void createGrade(int progress_id, int unit_id, BigDecimal score, String letter) {
        int success = gradeRepo.createStudentGrade(progress_id, unit_id, score, letter);
        if (success > 0) {
            System.out.println("Grade created successfully.");
        }else  {
            throw new FailedToCreateGrade("Failed to create grade for this unit " + unit_id);
        }
    }

    @Override
    public boolean updateGradeForStudent(int regNumber) {
        return false;
    }
}
