import { UserCartComponent } from "./user-cart.component";
import { TestBed, ComponentFixture, async } from '@angular/core/testing';

describe('UserCartComponent', () => {
    let component: UserCartComponent;
    let fixture: ComponentFixture<UserCartComponent>;
  
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        declarations: [ UserCartComponent ]
      })
      .compileComponents();
    }));
  
    beforeEach(() => {
      fixture = TestBed.createComponent(UserCartComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });
  
    it('should create', () => {
      expect(component).toBeTruthy();
    });
  });