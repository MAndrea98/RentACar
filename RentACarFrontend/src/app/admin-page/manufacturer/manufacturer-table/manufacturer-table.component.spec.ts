import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManufacturerTableComponent } from './manufacturer-table.component';

describe('ManufacturerTableComponent', () => {
  let component: ManufacturerTableComponent;
  let fixture: ComponentFixture<ManufacturerTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManufacturerTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManufacturerTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
