import { AdminReviewComponent } from "./admin-review.component";
import { TestBed, async, ComponentFixture } from '@angular/core/testing';

describe('AdminReviewComponent', () => {
    let component: AdminReviewComponent;
    let fixture: ComponentFixture<AdminReviewComponent>;
   
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        declarations: [ AdminReviewComponent ]
      })
      .compileComponents();
    }));
  
    beforeEach(() => {
      fixture = TestBed.createComponent(AdminReviewComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });
  
    it('should create', () => {
      expect(component).toBeTruthy();
    });
  });