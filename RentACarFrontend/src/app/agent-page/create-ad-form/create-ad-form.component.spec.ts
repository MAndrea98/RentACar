import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAdFormComponent } from './create-ad-form.component';

describe('CreateAdFormComponent', () => {
  let component: CreateAdFormComponent;
  let fixture: ComponentFixture<CreateAdFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAdFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAdFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
