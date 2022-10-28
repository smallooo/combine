package com.macro.mall.model;

import java.util.ArrayList;
import java.util.List;

public class AddresstoidExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddresstoidExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProviceidIsNull() {
            addCriterion("proviceid is null");
            return (Criteria) this;
        }

        public Criteria andProviceidIsNotNull() {
            addCriterion("proviceid is not null");
            return (Criteria) this;
        }

        public Criteria andProviceidEqualTo(Integer value) {
            addCriterion("proviceid =", value, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidNotEqualTo(Integer value) {
            addCriterion("proviceid <>", value, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidGreaterThan(Integer value) {
            addCriterion("proviceid >", value, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proviceid >=", value, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidLessThan(Integer value) {
            addCriterion("proviceid <", value, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidLessThanOrEqualTo(Integer value) {
            addCriterion("proviceid <=", value, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidIn(List<Integer> values) {
            addCriterion("proviceid in", values, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidNotIn(List<Integer> values) {
            addCriterion("proviceid not in", values, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidBetween(Integer value1, Integer value2) {
            addCriterion("proviceid between", value1, value2, "proviceid");
            return (Criteria) this;
        }

        public Criteria andProviceidNotBetween(Integer value1, Integer value2) {
            addCriterion("proviceid not between", value1, value2, "proviceid");
            return (Criteria) this;
        }

        public Criteria andQuidIsNull() {
            addCriterion("quid is null");
            return (Criteria) this;
        }

        public Criteria andQuidIsNotNull() {
            addCriterion("quid is not null");
            return (Criteria) this;
        }

        public Criteria andQuidEqualTo(Integer value) {
            addCriterion("quid =", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidNotEqualTo(Integer value) {
            addCriterion("quid <>", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidGreaterThan(Integer value) {
            addCriterion("quid >", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("quid >=", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidLessThan(Integer value) {
            addCriterion("quid <", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidLessThanOrEqualTo(Integer value) {
            addCriterion("quid <=", value, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidIn(List<Integer> values) {
            addCriterion("quid in", values, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidNotIn(List<Integer> values) {
            addCriterion("quid not in", values, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidBetween(Integer value1, Integer value2) {
            addCriterion("quid between", value1, value2, "quid");
            return (Criteria) this;
        }

        public Criteria andQuidNotBetween(Integer value1, Integer value2) {
            addCriterion("quid not between", value1, value2, "quid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}