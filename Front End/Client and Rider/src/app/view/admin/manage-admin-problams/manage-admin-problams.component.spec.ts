import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageAdminProblamsComponent } from './manage-admin-problams.component';

describe('ManageAdminProblamsComponent', () => {
  let component: ManageAdminProblamsComponent;
  let fixture: ComponentFixture<ManageAdminProblamsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageAdminProblamsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageAdminProblamsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
