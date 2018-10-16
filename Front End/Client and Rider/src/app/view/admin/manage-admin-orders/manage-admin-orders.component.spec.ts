import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageAdminOrdersComponent } from './manage-admin-orders.component';

describe('ManageAdminOrdersComponent', () => {
  let component: ManageAdminOrdersComponent;
  let fixture: ComponentFixture<ManageAdminOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageAdminOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageAdminOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
